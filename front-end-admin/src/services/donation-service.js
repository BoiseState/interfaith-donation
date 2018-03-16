import { getJSON, postJSON, patchJSON } from './helpers';

const BASE_API_ROUTE = 'donations';

export const createDonation = donation => {
  postJSON(BASE_API_ROUTE, donation)
    .catch(error => console.error('Error:', error))
    .then(response => console.log('Success:', response));
};

export const getAllDonations = async () => {
  let donations = await getJSON(BASE_API_ROUTE);
  return donations._embedded.donations;
};

export const getDonationById = async id => {
  let donation = await getJSON(`${BASE_API_ROUTE}/${id}`);
  return donation;
};

export const updateDonation = async donation => {
  return patchJSON(`${BASE_API_ROUTE}/${donation.id}`, donation);
};