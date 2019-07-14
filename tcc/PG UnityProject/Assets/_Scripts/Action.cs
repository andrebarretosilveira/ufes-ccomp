using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using TMPro;
using Pixelplacement;

[RequireComponent(typeof(CanvasGroup))]
public class Action : MonoBehaviour
{
    [Header("Visual Components")]
    public TextMeshProUGUI description;
    public Image actionImage;


    private CanvasGroup canvasGroup;
    private StoryManager.Plot.ActionEvent actionData;


    private void Awake()
    {
        canvasGroup = this.GetComponent<CanvasGroup>();
    }

    private void OnEnable()
    {
        description.text = "";

        description.text = actionData?.shortDescription;
        actionImage.sprite = GameManager.instance.ChooseActionTypeIcon(actionData);

        canvasGroup.interactable = true;
        canvasGroup.blocksRaycasts = true;

        OnEnableTween();
    }

    private void OnEnableTween()
    {
        transform.localScale = Vector3.one;
        canvasGroup.alpha = 0;

        // Tween.LocalScale(transform, Vector3.one, .2f, 0, Tween.EaseOut);
        Tween.CanvasGroupAlpha(canvasGroup, 1, .2f, 0, Tween.EaseOut);
    }

    public void ExecuteAction()
    {
        GameManager.instance.ExecutePlayerAction(actionData);
    }

    public void SetActionData(StoryManager.Plot.ActionEvent actionData)
    {
        this.actionData = actionData;
    }

}
