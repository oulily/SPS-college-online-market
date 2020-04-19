function setupBlobstore() {
  fetch('/sell')
    .then((response) => {
      return response.text();
    })
    .then((imageUploadUrl) => {
<<<<<<< HEAD
      let listingForm = document.getElementById('listing-form');
      listingForm.action = imageUploadUrl;
    });
}

function initAutocomplete() {
  let autocomplete = new google.maps.places.Autocomplete(document.getElementById('location'));
  autocomplete.setFields(['geometry']);

  document.getElementById('listing-form').addEventListener('submit', function(e) {
    e.preventDefault();
    let self = this;
    let geocoder = new google.maps.Geocoder();
    const address = document.getElementById('location').value;
    geocoder.geocode({'address': address}, function(results, status) {
      if (status === 'OK') {
        document.getElementById('location').value = JSON.stringify(results[0].geometry.location);
        self.submit();
      } else {
        alert('Please enter a valid address');
      }
    });
  });
=======
      const listingForm = document.getElementById('listing-form');
      listingForm.action = imageUploadUrl;
    });
>>>>>>> master
}