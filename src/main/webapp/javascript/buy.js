function getListings() {
  fetch('/buy').then(response => response.json())
  .then((listings) => {
    let listingSection = document.getElementById('listing-container');
    for (var i = 0; i < listings.length; i++) {
        listingSection.appendChild(createListing(listings[i]));
    }
  });
}

function createListing(listing) {
  const listingElement = document.createElement('div');
  listingElement.innerHTML = `
    <hr>
    <p>${listing.propertyMap.title}</p>
    <p>$${listing.propertyMap.price}</p>
    <img src="${listing.propertyMap.image}" alt="listing image">
    <p>${listing.propertyMap.description}</p>
    <input type="submit" value="Buy"> 
    <p>Posted on ` + new Date(listing.propertyMap.timestamp).toLocaleString('en-US') + `</p>
  `;              
  listingElement.appendChild(initMap(listing.propertyMap.location));

  return listingElement;
}

function initMap(location) {
    let mapBox = document.createElement('div');
    mapBox.setAttribute("id", "map");

    let coordinates = JSON.parse(location);
    let map = new google.maps.Map(mapBox, {
        center: coordinates,
        zoom: 15,
        disableDefaultUI: true
    });
    new google.maps.Marker({position: coordinates, map: map});

    return mapBox;
}