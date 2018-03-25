// export const URL = 'http://localhost:8800/';
export const URL = 'http://localhost:8080/donation-api';
export const getJSON = apiRoute =>
  fetch(`${URL}/${apiRoute}`, {
    method: 'GET'
  }).then(res => res.json());

export const postJSON = (apiRoute, data) =>
  fetch(`${URL}/${apiRoute}`, {
    method: 'POST',
    body: JSON.stringify(data),
    headers: new Headers({
      'Content-Type': 'application/json'
    }),
    mode: 'cors',
    cache: 'default'
  }).then(res => res.json());

export const patchJSON = (apiRoute, data) =>
  fetch(`${URL}/${apiRoute}`, {
    method: 'PATCH',
    body: JSON.stringify(data),
    headers: new Headers({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'PATCH',
      'Access-Control-Allow-Headers': 'Origin'
    }),
    mode: 'cors',
    cache: 'default'
  }).then(res => res.json());

export const deleteJSON = apiRoute =>
  fetch(`${URL}/${apiRoute}`, {
    method: 'DELETE'
  });
