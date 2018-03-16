import { getJSON, postJSON, patchJSON } from './helpers';

const BASE_API_ROUTE = 'alerts';

export const createAlert = async alert => {
  return postJSON(BASE_API_ROUTE, alert);
};

export const getAllAlerts = async () => {
  // getJSON(BASE_API_ROUTE + '/all').then(alerts => {
  //   return alerts.content;
  // });
  let alerts = await getJSON(BASE_API_ROUTE + '/all');
  return alerts.content;
};

export const getAlertById = async id => {
  let alert = await getJSON(`${BASE_API_ROUTE}/${id}`);
  return alert;
};

export const updateAlert = async alert => {
  return patchJSON(`${BASE_API_ROUTE}/${alert.id}`, alert);
};
