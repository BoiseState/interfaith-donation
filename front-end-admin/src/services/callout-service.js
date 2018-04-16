import { getJSON, postJSON, putJSON } from './helpers';

const BASE_API_ROUTE = 'callouts';

export const createCallout = async callout => {
  let newCallout = await postJSON(BASE_API_ROUTE, callout);
  return newCallout;
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
  return putJSON(`${BASE_API_ROUTE}/${callout.id}`, callout);
};
