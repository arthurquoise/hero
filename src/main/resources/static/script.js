let map;
const zoom = 8;
const latDefault = 50.628372508599256;
const longDefault = 3.0710624233913446;
let defaultCity = [latDefault, longDefault];
const ville = (new URLSearchParams(window.location.search)).get('ville');
const lat = (new URLSearchParams(window.location.search)).get('latitude');
const long = (new URLSearchParams(window.location.search)).get('longitude');
console.log(ville);
console.log(lat);
console.log(long);

const init = () => {

    let mainCity = !lat || !long ? defaultCity : [lat, long];
    console.log(mainCity);
    //let mainCity = defaultCity;

    map = L.map('map').setView(mainCity, zoom);

    L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        maxZoom: 18,
        id: 'mapbox/streets-v11',
        tileSize: 512,
        zoomOffset: -1,
        accessToken: 'pk.eyJ1IjoiYXJ0aHVycXVvaXNlIiwiYSI6ImNsMHR4aGRuZjAwdDIzaW1vYjl3aW1jcHMifQ.rnaft4ck3Rf7wN5-joZH1A'
    }).addTo(map);

    L.control.scale().addTo(map);

    let circleOptions = {
        color: 'red',
        fillColor: '#f03',
        fillOpacity: 0
    }

    let circle = L.circle(mainCity, 50000, circleOptions);

    circle.addTo(map);

}

init()

let myHero = obj !== null ? obj[0] : null;

//let hero = L.marker([50.29333, 2.77707])
//    .bindPopup(myHero.nom)
//    .addTo(map);
