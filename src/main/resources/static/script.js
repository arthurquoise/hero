let map;
let coord;
const zoom = 8;
let defaultCity = [50.628372508599256, 3.0710624233913446];
const city = (new URLSearchParams(window.location.search)).get('city');
const id = (new URLSearchParams(window.location.search)).get('id');
let url = new URL('https://nominatim.openstreetmap.org/search');
let paramUrl = {city: city, format:'json'}
url.search = new URLSearchParams(paramUrl).toString();
let api = `/getHeroes/${id}`;

const init = (cityCoordinates = defaultCity) => {

    map = L.map('map').setView(cityCoordinates, zoom);

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

    let circle = L.circle(cityCoordinates, 50000, circleOptions);

    circle.addTo(map);

}

function getCity(){
    return fetch(url.href)
        .then( response => {
            if (!response.ok) {
                throw new Error(`HTTP error: ${response.status}`);
            }
            return response.json();
        })
        .then( json => {
            return json;
        })
        .then(json => {
            coord = json;
        })
        .then(() => {
            let oneCity = coord[0];
            init([oneCity.lat, oneCity.lon]);
        })

        .catch( error => {
            console.error(`Could not get cities: ${error}`);
            init();
        });
}

function getHeroes(){
    return fetch(api)
        .then( res => {
            if (!res.ok) {
                throw new Error(`HTTP error: ${res.status}`);
            }
            return res.json();
        })
        .then( json => {
            json.forEach(hero => {
                let marker = L.marker([hero.villeLatitude, hero.villeLongitude])
                    .bindPopup(`${hero.nom} <br> ${hero.telephone}`)
                    .addTo(map);
            })
        })
        .catch( error => {
            console.error(`Could not get heroes: ${error}`);
        });
}
async function start(){
    await getCity();
    await getHeroes();
}

start();
