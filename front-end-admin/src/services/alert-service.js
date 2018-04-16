import { getJSON, postJSON, patchJSON } from './helpers';

const BASE_API_ROUTE = 'alerts';

export const createCallout = alert => {
  postJSON(BASE_API_ROUTE, alert);
};

export const getAllAlerts = async () => {
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
