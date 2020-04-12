function setupBlobstore() {
    fetch('/buy')
      .then((response) => {
        return response.text();
      })
      .then((imageUploadUrl) => {
        const listingForm = document.getElementById('listing-form');
        listingForm.action = imageUploadUrl;
      });
} 