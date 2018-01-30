import {getJSON} from './helpers';

const BASE_API_ROUTE = '/donors';

export const getAllDonors = () => {
  getJSON(BASE_API_ROUTE).then(donors => {
    return donors;
  });
};

export const getDonorById = async id => {
  let donor = await getJSON(`${BASE_API_ROUTE}/${id}`);
  return donor;
};
