import { getJSON, postJSON, putJSON } from './helpers';

const BASE_API_ROUTE = 'callouts';

export const createCallout = callout => {
  postJSON(BASE_API_ROUTE, callout)
    .catch(error => console.error('Error:', error))
    .then(response => console.log('Success:', response));
};

export const getAllCallouts = async () => {
  let callouts = await getJSON(BASE_API_ROUTE + '/all');
  return callouts.content;
};

export const getCalloutById = async id => {
  let callout = await getJSON(`${BASE_API_ROUTE}/${id}`);
  return callout;
};

export const updateCallout = async callout => {
  console.log(JSON.stringify(callout, null, 2));
  return putJSON(`${BASE_API_ROUTE}/${callout.id}`, callout);
};
