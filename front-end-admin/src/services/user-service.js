import {getJSON, postJSON, patchJSON} from './helpers';

const BASE_API_ROUTE = 'users';

export const createUser = user => {
  postJSON(BASE_API_ROUTE, user).catch(error => console.error('Error:', error)).then(response => console.log('Success:', response));
};

export const getAllUsers = async () => {
  let users = await getJSON(BASE_API_ROUTE);
  return users._embedded.users;
};

export const getUserById = async id => {
  let user = await getJSON(`${BASE_API_ROUTE}/${id}`);
  return user;
};

export const updateUser = async user => {
  return patchJSON(`${BASE_API_ROUTE}/${user.id}`, user);
};
