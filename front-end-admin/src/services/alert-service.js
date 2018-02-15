import {getJSON, postJSON, patchJSON} from './helpers';

const BASE_API_ROUTE = 'alerts';

export const createAlert = async alert => {
  return postJSON(BASE_API_ROUTE, alert);
};

export const getAllAlerts = () => {
  getJSON(BASE_API_ROUTE).then(alerts => {
    return alerts;
  });
};

export const getAlertById = async id => {
  let alert = await getJSON(`${BASE_API_ROUTE}/${id}`);
  return alert;
};

export const updateAlert = async alert => {
  return patchJSON(`${BASE_API_ROUTE}/${alert.id}`, alert);
};

