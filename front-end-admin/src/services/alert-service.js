import {getJSON} from './helpers';

const BASE_API_ROUTE = '/alerts';

export const getAllDonors = () => {
  getJSON(BASE_API_ROUTE).then(alerts => {
    return alerts;
  });
};

export const getAlertById = async id => {
  let alert = await getJSON(`${BASE_API_ROUTE}/${id}`);
  return alert;
};
