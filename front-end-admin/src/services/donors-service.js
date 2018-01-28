const URL = 'http://localhost:8080/donors';

export const getAllDonors = () => {
  let configuration = {method: 'GET'};
  fetch(URL, configuration).then(res => res.json()).then(res => {
    console.log(res);
  });
};
