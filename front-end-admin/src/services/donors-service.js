import {getJSON} from './helpers';

const BASE_API_ROUTE = '/donors';

export const getAllDonors = async () => {
  getJSON(BASE_API_ROUTE).then(donors => {
    console.log(donors);
  });
};

export const getDonorById = async id => {
  getJSON(`${BASE_API_ROUTE}/${id}`).then(donor => {
    console.log(donor);
  });
};
