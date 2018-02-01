import {getJSON} from './helpers';

const BASE_API_ROUTE = '/needs';

export const getAllNeeds = () => {
  getJSON(BASE_API_ROUTE).then(needs => {
    return needs;
  });
};

export const getNeedById = async id => {
  let need = await getJSON(`${BASE_API_ROUTE}/${id}`);
  return need;
};
