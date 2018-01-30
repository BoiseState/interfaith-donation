export const URL = 'http://localhost:8080';

export const getJSON = apiRoute => fetch(`${URL}/${apiRoute}`, {method: 'GET'}).then(res => res.json());
export const postJSON = apiRoute => fetch(`${URL}/${apiRoute}`, {method: 'POST'});
export const deleteJSON = apiRoute => fetch(`${URL}/${apiRoute}`, {method: 'DELETE'});
