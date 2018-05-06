var mymap = L.map('mapid').setView([45.53866990, -73.7], 11); // load la map sur montreal


L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,
    id: 'mapbox.streets',
    accessToken: 'pk.eyJ1IjoibWFnaWNoYWNrIiwiYSI6ImNqZ3UwdGlvbjEycmEzM3J0cWswbDE3MjQifQ.jkoppehVLlmtKaiNMGNztA'
}).addTo(mymap);

// image des arbres
var imageUrl = 'http://www.lib.utexas.edu/maps/historical/newark_nj_1922.jpg',
    imageBounds = [[45.401557, -73.979465], [45.702667, -73.476362]];
L.imageOverlay("mapQuartiersVERT.png", imageBounds).addTo(mymap); 

