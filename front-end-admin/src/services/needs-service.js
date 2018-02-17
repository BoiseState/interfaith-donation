import {getJSON, postJSON, patchJSON} from './helpers';

const BASE_API_ROUTE = 'needs';

export const createNeeds = async needs => {
  return postJSON(BASE_API_ROUTE, needs);
};

export const getAllNeeds = async () => {
  let needs = await getJSON(BASE_API_ROUTE);
  return needs._embedded.needs;
};

export const getNeedById = async id => {
  return getJSON(`${BASE_API_ROUTE}/${id}`);
};

export const updateNeed = async need => {
  return patchJSON(`${BASE_API_ROUTE}/${need.id}`, need);
};
