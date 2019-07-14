using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.Events;

public class OnEnableDisable : MonoBehaviour
{
    [Space]
    public UnityEvent OnEnableResponse;
    [Space]
    [Space]
    public UnityEvent OnDisableResponse;


    private void OnEnable()
    {
        OnEnableResponse.Invoke();
    }

    private void OnDisable()
    {
        OnDisableResponse.Invoke();
    }
}
