
function getConceptId(data, id){
  for(var i = 0; i < data.length; i++)
  {
    if(data[i].getAttribute("id") == id)
    {
      return i;
    }
  }
}

//var inputElement = document.getElementById("cmapFile");
//inputElement.addEventListener("change", readFile, false);

function readFile (evt) {
    var files = evt.target.files;
    var file = files[0];
    var reader = new FileReader();
    reader.onload = function() {
        var text = this.result;
        var parser, xmlDoc;
        parser = new DOMParser();
        xmlDoc = parser.parseFromString(text, "text/xml");

        document.getElementById("mapTitle").value = xmlDoc.getElementsByTagName("title")[0].childNodes[0].nodeValue;
        document.getElementById("question").value = xmlDoc.getElementsByTagName("description")[0].childNodes[0].nodeValue;

        var mapData = {"nodeKeyProperty":"id"};
        var nodeDataArray = [];
        mapData.nodeDataArray = nodeDataArray;

        var linkDataArray = [];
        mapData.linkDataArray = linkDataArray;

        var concepts = xmlDoc.getElementsByTagName("concept");
        var linkingPhrases = xmlDoc.getElementsByTagName("linking-phrase");
        var connections = xmlDoc.getElementsByTagName("connection");

        //Carregamento dos conceitos
        var cont = 0;
        var newConcept;
        for (var cont = 0; cont < concepts.length; cont++){
        newConcept = {
            "id" : cont,
            "text": concepts[cont].getAttribute("label")
        };
        mapData.nodeDataArray.push(newConcept);
        }

        // Carregar as connections de cada link
        var linkId, linkLabel;
        var listFromConcepts = [];
        var listToConcepts = [];

        for(var i = 0; i < linkingPhrases.length; i++)
        {
        listFromConcepts = [];
        listToConcepts = [];

        linkId = linkingPhrases[i].getAttribute("id");
        linkLabel = linkingPhrases[i].getAttribute("label");

        //Todos os conceitos que o linkID é TO
        for(var j = 0; j < connections.length; j++)
        {
            if(connections[j].getAttribute("to-id") == linkId)
            {
            listFromConcepts.push(connections[j].getAttribute("from-id"));
            }
        }

        //Todos os conceitos que o linkID é FROM
        for(var j = 0; j < connections.length; j++)
        {
            if(connections[j].getAttribute("from-id") == linkId)
            {
            listToConcepts.push(connections[j].getAttribute("to-id"));
            }
        }

        var fromConcept, toConcept, newLink, x, y;
        for(x = 0; x < listFromConcepts.length; x++)
        {
            fromConcept = listFromConcepts[x];
            for(y = 0; y < listToConcepts.length; y++)
            {
            toConcept = listToConcepts[y];
            newLink = {
                "from" : getConceptId(concepts, fromConcept),
                "to": getConceptId(concepts, toConcept),
                "text": linkLabel
            };
            mapData.linkDataArray.push(newLink);
            }
        }

        }


        myDiagram.model = go.Model.fromJson(mapData);

    }
    reader.readAsText(file)
}

function getIdByText(data, findText) {
    for(var i = 0; i < data.length; i++){
        if(data[i] == findText){
            return i;
        }
    }
    
}

function exportToCMap() {
    var xmltext = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";    
    xmltext += "\t<cmap xmlns:dcterms=\"http://purl.org/dc/terms/\" xmlns=\"http://cmap.ihmc.us/xml/cmap/\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:vcard=\"http://www.w3.org/2001/vcard-rdf/3.0#\">\n";
    xmltext += "\t\t<res-meta>\n";
    xmltext += "\t\t\t<dc:title>" + document.getElementById("mapTitle").value + "</dc:title>\n";
    xmltext += "\t\t\t<dc:description>" + document.getElementById("question").value + "</dc:description>\n";
    xmltext += "\t\t\t<dc:creator>\n";
    
    if(localStorage.getItem("token") != null){
        xmltext += "\t\t\t\t<vcard:FN>" + localStorage.getItem("first_name")+" "+ localStorage.getItem("last_name") + "</vcard:FN>\n";
        xmltext += "\t\t\t\t<vcard:EMAIL>" + localStorage.getItem("email")+"</vcard:EMAIL>\n";
    }else{
        xmltext += "\t\t\t\t<vcard:FN> CMPaaS Unauthenticated User </vcard:FN>\n";
        xmltext += "\t\t\t\t<vcard:EMAIL>cmpaas@gmail.com</vcard:EMAIL>\n";
    }
    
    xmltext += "\t\t\t</dc:creator>\n";
    
    xmltext += "\t\t\t<dc:contributor>\n";
    if(localStorage.getItem("token") != null){
        xmltext += "\t\t\t\t<vcard:FN>" + localStorage.getItem("first_name")+" "+ localStorage.getItem("last_name") + "</vcard:FN>\n";
        xmltext += "\t\t\t\t<vcard:EMAIL>" + localStorage.getItem("email")+"</vcard:EMAIL>\n";
    }else{
        xmltext += "\t\t\t\t<vcard:FN> CMPaaS Unauthenticated User </vcard:FN>\n";
        xmltext += "\t\t\t\t<vcard:EMAIL>cmpaas@gmail.com</vcard:EMAIL>\n";
    }
    xmltext += "\t\t\t</dc:contributor>\n";
    
    xmltext += "\t\t\t<dcterms:rightsHolder>\n";
    if(localStorage.getItem("token") != null){
        xmltext += "\t\t\t\t<vcard:FN>" + localStorage.getItem("first_name")+" "+ localStorage.getItem("last_name") + "</vcard:FN>\n";
        xmltext += "\t\t\t\t<vcard:EMAIL>" + localStorage.getItem("email")+"</vcard:EMAIL>\n";
    }else{
        xmltext += "\t\t\t\t<vcard:FN> CMPaaS Unauthenticated User </vcard:FN>\n";
        xmltext += "\t\t\t\t<vcard:EMAIL>cmpaas@gmail.com</vcard:EMAIL>\n";
    }
    xmltext += "\t\t\t</dcterms:rightsHolder>\n";
    
    if(localStorage.getItem("mapContentCreatedDate") != null){
        xmltext += "\t\t\t<dcterms:created>"+localStorage.getItem("mapContentCreatedDate")+"</dcterms:created>\n";
    }else{
        xmltext += "\t\t\t<dcterms:created>"+Date()+"</dcterms:created>\n";
    }
    xmltext += "\t\t\t<dc:language>pt</dc:language>\n";
    xmltext += "\t\t\t<dc:format>x-cmap/x-storable</dc:format>\n";
    xmltext += "\t\t</res-meta>\n";
    
    xmltext += "\t\t<map>\n";
    xmltext += "\t\t\t<concept-list>\n";
    
    var mapJSON = myDiagram.model.toJson();
    mapJSON = JSON.parse(mapJSON);
    var cont = 0;
    var concepts = [];        
    for(var i = 0; i < mapJSON.nodeDataArray.length; i++)
    {
        concepts[mapJSON.nodeDataArray[i].key] = cont;
        xmltext += "\t\t\t\t<concept id=\"" + cont + "\" label=\""+ mapJSON.nodeDataArray[i].text +"\"/>\n";
        cont++;
    }
    
    xmltext += "\t\t\t</concept-list>\n";
    
    xmltext += "\t\t\t<linking-phrase-list>\n";
    
    var links = [];
    for(var i = 0; i < mapJSON.linkDataArray.length; i++)
    {
        links[cont] = mapJSON.linkDataArray[i].text;
        xmltext += "\t\t\t\t<linking-phrase id=\"" + cont + "\" label=\""+ mapJSON.linkDataArray[i].text +"\"/>\n";
        cont++;
    }
    
    xmltext += "\t\t\t</linking-phrase-list>\n";
    
    xmltext += "\t\t\t<connection-list>\n";
    
    var linkId;
    for(var i = 0; i < mapJSON.linkDataArray.length; i++)
    {
        linkId = getIdByText(links, mapJSON.linkDataArray[i].text);
        xmltext += "\t\t\t\t<connection id=\"" + cont + "\" from-id=\""+ concepts[mapJSON.linkDataArray[i].from] +"\" to-id=\""+ linkId +"\"/>\n";
        cont++;
        xmltext += "\t\t\t\t<connection id=\"" + cont + "\" from-id=\""+ linkId +"\" to-id=\""+ concepts[mapJSON.linkDataArray[i].to] +"\"/>\n";
        cont++;
    }
    
    xmltext += "\t\t\t</connection-list>\n";
    
    xmltext += "\t\t\t<style-sheet-list>\n";
    xmltext += "\t\t\t\t<style-sheet id=\"_Default_\">\n";
    xmltext += "\t\t\t\t\t<map-style background-color=\"255,255,255,0\"/>\n";
    xmltext += "\t\t\t\t\t<concept-style font-name=\"Verdana\" font-size=\"12\" font-style=\"plain\" font-color=\"0,0,0,255\" text-margin=\"4\" background-color=\"237,244,246,255\" background-image-style=\"full\" border-color=\"0,0,0,255\" border-style=\"solid\" border-thickness=\"1\" border-shape=\"rounded-rectangle\" border-shape-rrarc=\"15.0\" text-alignment=\"center\" shadow-color=\"none\" min-width=\"-1\" min-height=\"-1\" max-width=\"-1.0\"/>\n";
    xmltext += "\t\t\t\t\t<linking-phrase-style font-name=\"Verdana\" font-size=\"12\" font-style=\"plain\" font-color=\"0,0,0,255\" text-margin=\"1\" background-color=\"0,0,255,0\" background-image-style=\"full\" border-color=\"0,0,0,0\" border-style=\"solid\" border-thickness=\"1\" border-shape=\"rectangle\" border-shape-rrarc=\"15.0\" text-alignment=\"center\" shadow-color=\"none\"/>\n";
    xmltext += "\t\t\t\t\t<connection-style color=\"0,0,0,255\" style=\"solid\" thickness=\"1\" type=\"straight\" arrowhead=\"if-to-concept-and-slopes-up\"/>\n";
    xmltext += "\t\t\t\t\t<resource-style font-name=\"SanSerif\" font-size=\"12\" font-style=\"plain\" font-color=\"0,0,0,255\" background-color=\"192,192,192,255\"/>\n";
    xmltext += "\t\t\t\t</style-sheet>\n";
    xmltext += "\t\t\t\t<style-sheet id=\"_LatestChanges_\">\n";
    xmltext += "\t\t\t\t\t<connection-style arrowhead=\"yes\"/>\n";
    xmltext += "\t\t\t\t</style-sheet>\n";
    xmltext += "\t\t\t</style-sheet-list>\n";
    xmltext += "\t\t\t<extra-graphical-properties-list>\n";
    xmltext += "\t\t\t\t<properties-list id=\"1Q41DT8ZP-1HWYM8X-6G\">\n";
    xmltext += "\t\t\t\t\t<property key=\"StyleSheetGroup_0\" value=\"//*@!#$%%^&amp;*()() No Grouped StyleSheets @\"/>\n";
    xmltext += "\t\t\t\t</properties-list>\n";
    xmltext += "\t\t\t</extra-graphical-properties-list>\n";
    xmltext += "\t\t</map>\n";
    xmltext += "\t</cmap>\n";
    
    var pom = document.createElement('a');

    var filename = "file.cxl";
    var pom = document.createElement('a');
    var bb = new Blob([xmltext], {type: 'text/plain'});

    pom.setAttribute('href', window.URL.createObjectURL(bb));
    pom.setAttribute('download', filename);

    pom.dataset.downloadurl = ['text/plain', pom.download, pom.href].join(':');
    pom.draggable = true; 
    pom.classList.add('dragout');

    pom.click();
}