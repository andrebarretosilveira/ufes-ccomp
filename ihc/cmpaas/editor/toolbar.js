/*colorButton = document.getElementById("demo2");
colorButton.addEventListener("input", function() {
  myDiagram.startTransaction("change color");
  var it = myDiagram.selection.iterator;
  while (it.next()) {
    var node = it.value;
    var shape = node.findObject("SHAPE");
    if (shape !== null) {
      shape.fill = colorButton.value;
    }
  }
  myDiagram.commitTransaction("change color");
});*/

var boldButton = document.getElementById("bold");
boldButton.addEventListener("click", function() {
  myDiagram.startTransaction("change font style");
  var it = myDiagram.selection.iterator;
  var equalStylesVar = equalStyles('bold',myDiagram.selection.iterator)
  while (it.next()) {
    var node = it.value;
    var textBlock = node.findObject("TEXTBLOCK");
    if (textBlock !== null) {
      textBlock.font = setFontStyle('bold',textBlock.font,equalStylesVar)
    }
  }
  myDiagram.commitTransaction("change font style");
});

var italicButton = document.getElementById("italic");
italicButton.addEventListener("click", function() {
  myDiagram.startTransaction("change font style");
  var it = myDiagram.selection.iterator;
  var equalStylesVar = equalStyles('italic',myDiagram.selection.iterator)
  while (it.next()) {
    var node = it.value;
    var textBlock = node.findObject("TEXTBLOCK");
    if (textBlock !== null) {
      textBlock.font = setFontStyle('italic',textBlock.font,equalStylesVar)
    }
  }
  myDiagram.commitTransaction("change font style");
});

var underlineButton = document.getElementById("underline");
underlineButton.addEventListener("click", function() {
  myDiagram.startTransaction("change font style");
  var it = myDiagram.selection.iterator;
  var equalStylesVar = equalStyles('underline',myDiagram.selection.iterator)
  while (it.next()) {
    var node = it.value;
    var textBlock = node.findObject("TEXTBLOCK");
    if (textBlock !== null) {
      textBlock.isUnderline = setFontStyle('underline',textBlock.isUnderline,equalStylesVar)
    }
  }
  myDiagram.commitTransaction("change font style");
});



function equalStyles(style,selectedModels){

  var it = selectedModels.iterator;
  while (it.next()) {
    var node = it.value;
    var textBlock = node.findObject("TEXTBLOCK");
    if (textBlock !== null) {

      if (style === 'underline') {
        if (textBlock.isUnderline === null || !textBlock.isUnderline) {
          return false
        }
      } else {
        if (textBlock.font.search(style) == -1) {
          return false
        }
      }
    }
  }
  return true
}


function trimFont(font){
  var count = 1
  var arrayOfStrings = font.split(',')
  font = ''

  arrayOfStrings.forEach(
    function(string){
      if(count === arrayOfStrings.length){
      font += string.trim()

    } else {

      font += `${string.trim()}, `

    }

    count++

  })

  return font
}

function setFontStyle(style, font, equalStyles){

  var newFont = font

  switch (style) {

    case 'bold':
      if (equalStyles) {

        newFont = font.replace(/bold/g, '');

      } else if (font.search('bold') == -1){

        newFont = `bold ${font}`

      }
      newFont = trimFont(newFont)
      break;
      case 'italic':
        if (equalStyles) {

          newFont = font.replace('italic ', '');

        } else if (font.search('italic') == -1){

          newFont = `italic ${font}`

        }

        newFont = trimFont(newFont)
        break;
        case 'underline':
          if (equalStyles) {

            newFont = false;

          } else if (font === null || !font){

            newFont = true

          }
          break;
    default:

  }


  return newFont
}


$(function(){

    var inputColor = $('#inputColor');
    inputColor.colorpickerplus();
    inputColor.on('changeColor', function(e,color){
  if(color==null) {
    //when select transparent color
    $('.color-fill-icon', $(this)).addClass('colorpicker-color');
  } else {
    $('.color-fill-icon', $(this)).removeClass('colorpicker-color');
        $('.color-fill-icon', $(this)).css('background-color', color);

        colorButton.value = color
        colorButton.dispatchEvent(new Event('input'));
  }
    });

});


function setFont(newFont, font){

  var splitedFont = font.split(',')

  var returnedFont = ''

  var string = ''

  splitedFont.forEach(function(item,index){

    var splitedFontStyle = item.split(' ')

    splitedFontStyle[splitedFontStyle.length-1] = newFont

    splitedFontStyle.forEach(function(item){

      string += `${item} `

    })

    string = string.trim()
    item = string

    if(index == splitedFont.length-1){
      returnedFont += `${item}`
    } else {
      returnedFont += `${item}, `
    }

    string = ''

  })

  return returnedFont

}

function setFontSize(newFontSize, font){

  var splitedFont = font.split(',')

  var returnedFont = ''

  var string = ''

  splitedFont.forEach(function(item,index){

    var splitedFontStyle = item.split(' ')

    if(splitedFontStyle.length > 1){

      if(splitedFontStyle[splitedFontStyle.length-2] !== 'italic' && splitedFontStyle[splitedFontStyle.length-2] !== 'bold'){

        splitedFontStyle[splitedFontStyle.length-2] = `${newFontSize}pt`

      }

    }

    splitedFontStyle.forEach(function(item){

      string += `${item} `

    })

    string = string.trim()
    item = string

    if(index == splitedFont.length-1){
      returnedFont += `${item}`
    } else {
      returnedFont += `${item}, `
    }

    string = ''

  })

  return returnedFont

}

$('.font').on('click', function(){
  var option = $(this).text();

  var fontName = this.id

  $('#selectedfont').html(option);

  myDiagram.startTransaction("change font");
  var it = myDiagram.selection.iterator;


  while (it.next()) {
    var node = it.value;
    var textBlock = node.findObject("TEXTBLOCK");
    if (textBlock !== null) {
      textBlock.font = setFont(fontName,textBlock.font)
    }
  }

  myDiagram.commitTransaction("change font");

});

$('.font-size').on('click', function(){
  var option = $(this).text();

  var fontSize = this.id

  $('#selectedfontsize').html(option);

  myDiagram.startTransaction("change font size");
  var it = myDiagram.selection.iterator;


  while (it.next()) {
    var node = it.value;
    var textBlock = node.findObject("TEXTBLOCK");
    if (textBlock !== null) {
      textBlock.font = setFontSize(fontSize,textBlock.font)
    }
  }

  myDiagram.commitTransaction("change font size");

});

myDiagram.addDiagramListener("ChangedSelection", function() {

  var it = myDiagram.selection.iterator;
  while (it.next()) {
    var node = it.value
    var shape = node.findObject("SHAPE")
    var textBlock = node.findObject("TEXTBLOCK")
    if(shape !== null){
      var fillButton = document.getElementById("fill-icon")
      fillButton.style = `background-color: ${shape.fill};`
    }
    if(textBlock !== null){

      var fontNames = textBlock.font.split(',')
      var fontArray = fontNames[0].split(' ')
      var fontId = fontArray[fontArray.length-1]
      $('#selectedfont').html($(`#${fontId}`).text())

      if(fontArray.length > 1){

        if(fontArray[fontArray.length-2] !== 'italic' && fontArray[fontArray.length-2] !== 'bold'){

          var fontSize = fontArray[fontArray.length-2]
          fontSize = fontSize.replace('pt','')
          $('#selectedfontsize').html($(`#${fontSize}`).text())

        }

      }

    }
  }

});
