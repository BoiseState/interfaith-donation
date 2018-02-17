import {getJSON, postJSON, patchJSON} from './helpers';

const BASE_API_ROUTE = '/donors';

export const createDonor = donor => {
  postJSON(BASE_API_ROUTE, donor).catch(error => console.error('Error:', error)).then(response => console.log('Success:', response));
};

export const getAllDonors = async () => {
  let donors = await getJSON(BASE_API_ROUTE);
  return donors._embedded.donors;
};

export const getDonorById = async id => {
  let donor = await getJSON(`${BASE_API_ROUTE}/${id}`);
  return donor;
};

export const updateDonor = async donor => {
  return patchJSON(`${BASE_API_ROUTE}/${donor.id}`, donor);
};
