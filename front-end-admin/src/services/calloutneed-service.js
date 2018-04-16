import { getJSON, postJSON, patchJSON } from './helpers';

const BASE_API_ROUTE = 'calloutneeds';

export const createCalloutNeed = calloutNeed => {
  postJSON(BASE_API_ROUTE, calloutNeed);
};

export const getAllCalloutNeeds = async () => {
  let calloutNeeds = await getJSON(BASE_API_ROUTE + '/all');
  return calloutNeeds.content;
};

export const getCalloutNeedByCalloutId = async calloutId => {
  let calloutNeeds = await getJSON(`${BASE_API_ROUTE}/callout/${calloutId}`);
  return calloutNeeds;
};

export const getCalloutNeedById = async id => {
  let calloutNeed = await getJSON(`${BASE_API_ROUTE}/${id}`);
  return calloutNeed;
};

export const updateCalloutNeed = async calloutNeed => {
  return patchJSON(`${BASE_API_ROUTE}/${calloutNeed.id}`, calloutNeed);
};
