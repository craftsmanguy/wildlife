const express = require('express');
const router = express.Router();

// declare axios for making http requests
const axios = require('axios');
const HOST = 'http://wildlives-int.ovh:8081';
const CONTEXT = 'business';
const VERSION = 'v1';
const PET_RESOURCE = 'pets';
const RACE_RESOURCE = 'races';


router.get('/v1/pets/:id', (req, res, next) => {
  axios({
    method: 'get',
    url: `${HOST}/${CONTEXT}/${VERSION}/${PET_RESOURCE}/` + req.params.id,
    responseType: 'json',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': req.cookies['access_token'],
    }
  })
    .then(function (response) {
      res.status(response.status).json(response.data);
    })
    .catch(function (error) {
      errorHandler(error, res);
    });
});


router.get('/v1/pets', (req, res, next) => {
  axios({
    method: 'get',
    url: `${HOST}/${CONTEXT}/${VERSION}/${PET_RESOURCE}`,
    responseType: 'json',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': req.cookies['access_token'],
    }
  })
    .then(function (response) {
      res.status(response.status).json(response.data);
    })
    .catch(function (error) {
      errorHandler(error, res);
    });
});

router.delete('/v1/pets/:id', (req, res, next) => {
  axios({
    method: 'delete',
    url: `${HOST}/${CONTEXT}/${VERSION}/${PET_RESOURCE}/` + req.params.id,
    responseType: 'json',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': req.cookies['access_token'],
    }
  })
    .then(function (response) {
      res.status(response.status).json(response.data);
    })
    .catch(function (error) {
      errorHandler(error, res);
    });
});


router.post('/v1/pets', (req, res, next) => {
  axios({
    method: 'post',
    url: `${HOST}/${CONTEXT}/${VERSION}/${PET_RESOURCE}`,
    data: req.body,
    headers: {
      'Content-Type': 'application/json',
      'Authorization': req.cookies['access_token'],
    }
  })
    .then(function (response) {
      res.status(response.status).json(response.data);
    })
    .catch(function (error) {
      errorHandler(error, res);
    });
});


router.put('/v1/pets/:id', (req, res, next) => {
  axios({
    method: 'put',
    url: `${HOST}/${CONTEXT}/${VERSION}/${PET_RESOURCE}/` + req.params.id,
    data: req.body,
    headers: {
      'Content-Type': 'application/json',
      'Authorization': req.headers.authorization,
    }
  })
    .then(function (response) {
      res.status(response.status).json(response.data);
    })
    .catch(function (error) {
      errorHandler(error, res);
    });
});


router.get('/v1/races', (req, res, next) => {
  axios({
    method: 'get',
    url: `${HOST}/${CONTEXT}/${VERSION}/${RACE_RESOURCE}`,
    headers: {
      'Content-Type': 'application/json',
      'Authorization': req.cookies['access_token'],
    }
  })
    .then(function (response) {
      res.status(response.status).json(response.data);
    })
    .catch(function (error) {
      errorHandler(error, res);
    });
});

function errorHandler(error, res) {
  if (error.response) {
    return res.status(error.response.status).send(error.response.headers.reason);
  } else if (error.request) {
    res.status(503).send('The server is currently unable to handle the request due to a temporary overloading or maintenance of the server.');
  } else {
    res.status(500).send('The server encountered an unexpected condition which prevented it from fulfilling the request.')
  }
};


module.exports = router;