import {getJSON, postJSON, patchJSON} from './helpers';

const BASE_API_ROUTE = 'callouts';

export const createCallout = async callout => {
  return postJSON(BASE_API_ROUTE, callout);
};

export const getAllCallouts = async () => {
  let callouts = await getJSON(BASE_API_ROUTE);
  return callouts;
};

export const getCalloutById = async id => {
  return getJSON(`${BASE_API_ROUTE}/${id}`);
};

export const updateCallout = async callout => {
  return patchJSON(`${BASE_API_ROUTE}/${callout.id}`, callout);
};
