using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using TMPro;

[RequireComponent(typeof(Toggle))]
public class OnToggle : MonoBehaviour
{
    public TextMeshProUGUI label;

    private Toggle toggle;


    private void Awake()
    {
        toggle = this.GetComponent<Toggle>();
    }

    public void OnToggleState()
    {
        if(toggle.isOn) OnToggleOn();
        else  OnToggleOff();
    }

    public void OnToggleOn()
    {
        label.fontStyle = FontStyles.Bold;
        label.color = Color.black;
    }

    public void OnToggleOff()
    {
        label.fontStyle = FontStyles.Normal;
        label.color = Color.white;
        transform.SetAsFirstSibling();
    }
}
