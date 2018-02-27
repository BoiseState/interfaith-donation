FROM node:8.9.4
WORKDIR /usr/src/app

RUN npm install -g nodemon@1.11.0

COPY package*.json ./

RUN npm install

COPY . .

CMD ["npm", "start"]
