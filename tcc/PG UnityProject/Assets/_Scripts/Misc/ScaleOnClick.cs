using UnityEngine;
using UnityEngine.EventSystems;
using Pixelplacement;

public class ScaleOnClick : MonoBehaviour, IPointerDownHandler, IPointerUpHandler, IPointerExitHandler
{
    public Vector3 NormalScale = Vector3.one;
    public Vector3 ClickedScale;
    public float ScaleTime;

    //
    // For UI Objects
    //
    public void OnPointerDown(PointerEventData eventData)
    {
        ScaleUp();
    }

    public void OnPointerUp(PointerEventData eventData)
    {
        ScaleDown();
    }

    public void OnPointerExit(PointerEventData eventData)
    {
        ScaleDown();
    }

    //
    // For GameObjects
    //
    private void OnMouseDown()
    {
        ScaleUp();
    }

    private void OnMouseUp()
    {
        ScaleDown();
    }

    private void OnMouseExit()
    {
        ScaleDown();
    }

    //
    // Actual Scaling
    //

    public void ScaleUp()
    {
        Tween.LocalScale(this.transform, ClickedScale, ScaleTime, 0);
    }

    public void ScaleDown()
    {
        Tween.LocalScale(this.transform, NormalScale, ScaleTime, 0);
    }

}
