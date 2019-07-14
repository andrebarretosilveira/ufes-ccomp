using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using StoryManager;
using Pixelplacement;
using UnityEngine.UI;

[RequireComponent(typeof(CanvasGroup))]
public class EventUpdater : MonoBehaviour
{
    public TMPro.TextMeshProUGUI eventDescription;
    public Image actionIcon;

    private CanvasGroup canvasGroup;
    private Plot.Event eventData;


    private void Awake()
    {
        canvasGroup = this.GetComponent<CanvasGroup>();
    }

    private void OnEnable()
    {
        eventDescription.text = "";

        if(eventData == null) return;

        if(eventData is StoryManager.Plot.ActionEvent)
        {
            var action = eventData as StoryManager.Plot.ActionEvent;

            eventDescription.text = "<color=#333>" + action.actor.displayName + "\n-----------\n</color>";
            actionIcon.sprite = GameManager.instance.ChooseActionTypeIcon(action);
        }
        else
        {
            actionIcon.gameObject.SetActive(false);
        }

        eventDescription.text += eventData.description;

        OnEnableTween();
    }

    private void OnEnableTween()
    {
        transform.localScale = Vector3.one;
        canvasGroup.alpha = 0;

        // Tween.LocalScale(transform, Vector3.one, .1f, 0, Tween.EaseOut);
        Tween.CanvasGroupAlpha(canvasGroup, 1, .6f, 0, Tween.EaseOut);
    }


    public void SetEventData(Plot.Event eventData)
    {
        this.eventData = eventData;
    }

}
