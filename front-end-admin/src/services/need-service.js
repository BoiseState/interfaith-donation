import { getJSON, postJSON, putJSON } from './helpers';

const BASE_API_ROUTE = 'needs';

export const createNeed = async need => {
  return postJSON(BASE_API_ROUTE, need)
    .catch(error => console.error('Error:', error))
    .then(response => console.log('Success:', response));
};

export const getAllNeeds = async () => {
  let needs = await getJSON(BASE_API_ROUTE + '/all');
  return needs.content;
};

export const getNeedById = async id => {
  return getJSON(`${BASE_API_ROUTE}/${id}`);
};

export const updateNeed = async need => {
  return putJSON(`${BASE_API_ROUTE}/${need.id}`, need);
};
