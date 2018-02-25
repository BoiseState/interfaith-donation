FROM node:8.9.4
WORKDIR /app/client

RUN npm install -g nodemon@1.11.0

COPY package.json /app/client/package.json
RUN npm install && npm ls
RUN mv /app/client/node_modules /node_modules

COPY . /app/client

CMD ["npm", "start"]
