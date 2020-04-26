function getDataServlet() {
  console.log('Fetching a Hello.');

  const responsePromise = fetch('/signup');

  responsePromise.then(handleResponse);
}

function handleResponse(response) {
  console.log('Handling the response.');

  const textPromise = response.text();

  textPromise.then(addDataServletToDom);
}

function addDataServletToDom(texts) {
  console.log('Adding quote to dom: ' + texts);

  const textsContainer = document.getElementById('dataServlet-container');
  textsContainer.innerHTML= texts;
}


function getTextUsingArrowFunctions() {
  fetch('/signup').then(response => response.text()).then((texts) => {
    document.getElementById('dataServlet-container').innerHTML = texts;
  });
}


async function getTextUsingAsyncAwait() {
  const response = await fetch('/signup');
  const texts = await response.text();
  document.getElementById('dataServlet-container').innerHTML = texts;
}

async function getList() {

const response = await fetch('/signup');
const comments = await response.json();
const commentList = document.getElementById("dataServlet-container");
commentList.innerHTML = '';
comments.forEach((line) => {
    console.log(line);
    commentList.appendChild(createListElement(line));

});
}


