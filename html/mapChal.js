var mymap = L.map('mapid').setView([45.53866990, -73.7], 11); // load la map sur montreal


L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,
    id: 'mapbox.streets',
    accessToken: 'pk.eyJ1IjoibWFnaWNoYWNrIiwiYSI6ImNqZ3UwdGlvbjEycmEzM3J0cWswbDE3MjQifQ.jkoppehVLlmtKaiNMGNztA'
}).addTo(mymap);


// mymap.disableClusteringAtZoom = 15;

var sauce = 0;
var geojsonMarkerOptions = {
    radius: 8,
    fillColor: "#ff7800",
    color: "#000",
    weight: 1,
    opacity: 1,
    fillOpacity: 0.8
};

$.getJSON("sauce.json", function(json) {
    console.log("test");
    console.log(json);
    L.geoJSON(json, {
    pointToLayer : function(feature, latlng) {
        color = 0
    if(feature.properties.valeur > 8){
       color = "#EB2512"
       }
    else if(feature.properties.valeur > 6){
       color = "#E97D66"
       }
    else if(feature.properties.valeur > 4){
       color = "#E5CD77"
       }
    else if(feature.properties.valeur > 2){
       color = "#C4E577"
       }
    else{
        color = "#77E5C4"
    }
        sauce = sauce + 1;
        if(!(sauce % 1)){ // on affiche certaines données seulent pour pas overlaod le broweser
       return L.circleMarker(latlng ,{
    radius: 8,
    fillColor: color,
    color: "#000",
    weight: 1,
    opacity: 0,
    fillOpacity: 1
});
        }
        return false;
        
    }
}).addTo(mymap);
})


