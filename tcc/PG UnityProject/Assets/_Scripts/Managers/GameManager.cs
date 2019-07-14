using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using TMPro;
using StoryManager;
using System;

public class GameManager : MonoBehaviour
{
    public static GameManager instance;

    [Header("GameObjs References")]
    public GameObject plotContent;
    public GameObject actionsContent;
    [Space]
    public TextMeshProUGUI playerStatus;
    public TextMeshProUGUI storyStatus;
    [Space]
    public GameObject restartAction;
    public GameObject quitAction;
    [Space]
    public Scrollbar plotContentScrollbar;

    [Header("Prefabs")]
    public GameObject actionPrefab;
    public GameObject plotEventPrefab;

    [Header("Action Type Icons")]
    public Sprite idleIcon;
    public Sprite interactionIcon;
    public Sprite visualIcon;
    public Sprite movementIcon;
    public Sprite communicationIcon;
    public Sprite combatIcon;
    
    private bool isUpdatingUI = false;

    private void Awake()
    {
        if (instance == null) { instance = this; }
        else { Destroy(this.gameObject); }
    }

    //-----
    #region Game General Management

    private void Start()
    {
        restartAction.SetActive(false);
        quitAction.SetActive(false);

        ClearPlayerStatus();
        ClearPastEvents();
        ClearAvailableActions();

        var occurredEvents = BeginStory();
        
        StartCoroutine(UpdateGameUI(occurredEvents));
    }

    private void Update()
    {
        if(isUpdatingUI) plotContentScrollbar.value = 0;
    }

    public void ExecutePlayerAction(Plot.ActionEvent action)
    {
        SetAvailableActionsInactive();

        var occurredEvents = DoPlayerAction(action);

        StartCoroutine(UpdateGameUI(occurredEvents));
    }

    private IEnumerator UpdateGameUI(List<Plot.Event> ocurredEvents)
    {
        isUpdatingUI = true;

        UpdatePlayerStatus();

        UpdateStoryStatus();

        yield return StartCoroutine(AddEventsToPlotSequence(ocurredEvents));

        ClearAvailableActions();

        AddAvailableActions();

        isUpdatingUI = false;
    }

    private IEnumerator AddEventsToPlotSequence(List<Plot.Event> events)
    {
        foreach (var e in events)
        {
            var eventObj = PoolManager.instance.GetClone(plotEventPrefab, true);
            var plotEvent = eventObj.GetComponent<EventUpdater>();

            // Set the event's script Plot.Event data
            plotEvent.SetEventData(e);

            eventObj.transform.SetParent(plotContent.transform);
            eventObj.SetActive(true);

            yield return new WaitForSeconds(.5f);
        }
    }

    private void AddAvailableActions()
    {
        if(Story.__isOver)
        {
            restartAction.SetActive(true);
            quitAction.SetActive(true);

            return;
        }

        foreach (var actionEvent in GetAvailableActions())
        {
            var actionObj = PoolManager.instance.GetClone(actionPrefab, true);
            var action = actionObj.GetComponent<Action>();

            // Set the action's script Plot.ActionEvent data
            action.SetActionData(actionEvent);

            actionObj.transform.SetParent(actionsContent.transform);
            actionObj.SetActive(true);
        }
    }

    private void SetAvailableActionsInactive()
    {
        foreach (Transform child in actionsContent.transform)
        {
            var cg = child.GetComponent<CanvasGroup>();
            cg.blocksRaycasts = false;
            cg.interactable = false;
        }
    }

    private void ClearAvailableActions()
    {
        foreach (Transform child in actionsContent.transform)
        {
            child.gameObject.SetActive(false);
        }
    }

    private void ClearPastEvents()
    {
        foreach (Transform child in plotContent.transform)
        {
            child.gameObject.SetActive(false);
        }
    }

    private void ClearPlayerStatus()
    {
        playerStatus.text = "";
    }

    private void UpdatePlayerStatus()
    {
        playerStatus.text = GetPlayerStatus();
    }

    private void UpdateStoryStatus()
    {
        storyStatus.text = GetStoryStatus();
    }

    public Sprite ChooseActionTypeIcon(StoryManager.Plot.ActionEvent actionData)
    {
        if(actionData == null) return interactionIcon;

        switch (actionData.type)
        {
            case StoryManager.ActionType.Interaction:
                return interactionIcon;
            
            case StoryManager.ActionType.Visual:
                return visualIcon;

            case StoryManager.ActionType.Movement:
                return movementIcon;

            case StoryManager.ActionType.Combat:
                return combatIcon;

            case StoryManager.ActionType.Communication:
                return communicationIcon;

            case StoryManager.ActionType.Idle:
            default:
                return idleIcon;
        }
    }

    #endregion


    //-----
    #region Story Medium

    private List<Plot.Event> BeginStory()
    {
        Story.Init();

        return Story.Begin();
    }

    private List<Plot.Event> DoPlayerAction(Plot.ActionEvent action) 
    {
        return Story.Tick(action);
    }

    private string GetPlayerStatus()
    {
        var attrsDict = StoryManager.Story.space.player.GetAttributes();
        string statusText = "";

        foreach(KeyValuePair<string, string> entry in attrsDict)
        {
            statusText += entry.Key + " = " + entry.Value + "\n";
        }

        return statusText;
    }

    private string GetStoryStatus()
    {
        var attrsDict = StoryManager.Story.GetAttributes();
        string statusText = "";

        foreach(KeyValuePair<string, string> entry in attrsDict)
        {
            statusText += entry.Key + " = " + entry.Value + "\n";
        }

        return statusText;
    }

    private List<Plot.ActionEvent> GetAvailableActions()
    {
        return Story.GetPossiblePlayerActions();
    }
    
    #endregion

}
