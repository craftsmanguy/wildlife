const express = require('express');
const router = express.Router();

const axios = require('axios');
const HOST = 'http://wildlives-int.ovh:8081';
const CONTEXT = 'business';
const VERSION = 'v1';
const ADVERT_RESOURCE = 'adverts';
const FORMAT_RESOURCE = 'formats';


router.get('/v1/formats', (req, res, next) => {
  axios({
    method: 'get',
    url: `${HOST}/${CONTEXT}/${VERSION}/${FORMAT_RESOURCE}`,
    responseType: 'json',
    headers: {
      'Content-Type': 'application/json'
    }
  }).then(function(response) {
      res.status(response.status).json(response.data);
  }).catch(function(error) {
      if (error.response) {
        res.status(error.response.status).json(error.response.data.description);
      } else if (error.request) {
        console.log('requete erreur : ' + error);
        res.status(503).send('The server is currently unable to handle the request due to a temporary overloading or maintenance of the server.');
      } else {
        // Something happened in setting up the request that triggered an Error
        res.status(500).send('The server encountered an unexpected condition which prevented it from fulfilling the request.')
      }
    });
});


router.get('/v1/adverts', (req, res, next) => {
  axios({
    method: 'get',
    url: `${HOST}/${CONTEXT}/${VERSION}/${ADVERT_RESOURCE}`,
    responseType: 'json',
    headers: {
      'Content-Type': 'application/json'
    }
  }).then(function(response) {
      res.status(response.status).json(response.data);
  }).catch(function(error) {
      if (error.response) {
        res.status(error.response.status).json(error.response.data.description);
      } else if (error.request) {
        console.log('requete erreur : ' + error);
        res.status(503).send('The server is currently unable to handle the request due to a temporary overloading or maintenance of the server.');
      } else {
        // Something happened in setting up the request that triggered an Error
        res.status(500).send('The server encountered an unexpected condition which prevented it from fulfilling the request.')
      }
    });
});

router.get('/v1/adverts/:id', (req, res, next) => {
  axios({
    method: 'get',
    url: `${HOST}/${CONTEXT}/${VERSION}/${ADVERT_RESOURCE}/` + req.params.id,
    responseType: 'json',
    headers: {
      'Content-Type': 'application/json'
    }
  }).then(function(response) {
      res.status(response.status).json(response.data);
  }).catch(function(error) {
      if (error.response) {
        res.status(error.response.status).json(error.response.data.description);
      } else if (error.request) {
        console.log('requete erreur : ' + error);
        res.status(503).send('The server is currently unable to handle the request due to a temporary overloading or maintenance of the server.');
      } else {
        // Something happened in setting up the request that triggered an Error
        res.status(500).send('The server encountered an unexpected condition which prevented it from fulfilling the request.')
      }
    });
});

//Remove campaign by Id
router.delete('/v1/adverts/:id', (req, res, next) => {	
  axios({
    method: 'delete',
    url: `${HOST}/${CONTEXT}/${VERSION}/${ADVERT_RESOURCE}/` + req.params.id,
    responseType: 'json',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': req.headers.authorization,
    }
  })
    .then(function(response) {
      res.status(response.status).json(response.data);
    })
    .catch(function(error) {
      if (error.response) {
        res.status(error.response.status).json(error.response.data.description);
      } else if (error.request) {
        console.log('requete erreur : ' + error);
        res.status(503).send('The server is currently unable to handle the request due to a temporary overloading or maintenance of the server.');
      } else {
        // Something happened in setting up the request that triggered an Error
        res.status(500).send('The server encountered an unexpected condition which prevented it from fulfilling the request.')
      }
    });
});

/*
 * Add adverts
 */
router.post('/v1/adverts', (req, res, next) => {
  axios({
    method: 'post',
    url: `${HOST}/${CONTEXT}/${VERSION}/${ADVERT_RESOURCE}`,
    data: {
      functionalIdentifier: req.body.id,
      title: req.body.title,
      startDate: req.body.startDate,
      endDate: req.body.endDate,
      description: req.body.description,
      formats: req.body.formats,
      pets: req.body.pets
    },
    headers: {
      'Content-Type': 'application/json',
      'Authorization': req.headers.authorization,
    }
  })
    .then(function(response) {
      res.status(response.status).json(response.headers);
    })
    .catch(function(error) {
      if (error.response) {
        res.status(error.response.status).json(error.response.data.description);
      } else if (error.request) {
        console.log('requete erreur : ' + error);
        res.status(503).send('The server is currently unable to handle the request due to a temporary overloading or maintenance of the server.');
      } else {
        // Something happened in setting up the request that triggered an Error
        console.log('requete erreur : ' + error);
        res.status(500).send('The server encountered an unexpected condition which prevented it from fulfilling the request.')
      }
    });
});


router.put('/v1/adverts/:id', (req, res, next) => {
  axios({
    method: 'put',
    url: `${HOST}/${CONTEXT}/${VERSION}/${ADVERT_RESOURCE}`,
    data: {
      functionalIdentifier: req.body.id,
      title: req.body.title,
      startDate: req.body.startDate,
      endDate: req.body.endDate,
      description: req.body.description,
      formats: req.body.formats,
      pets: req.body.pets
    },
    headers: {
      'Content-Type': 'application/json',
      'Authorization': req.headers.authorization,
    }
  })
    .then(function(response) {
      res.status(response.status).json(response.headers);
    })
    .catch(function(error) {
      if (error.response) {
        res.status(error.response.status).json(error.response.data.description);
      } else if (error.request) {
        console.log('requete erreur : ' + error);
        res.status(503).send('The server is currently unable to handle the request due to a temporary overloading or maintenance of the server.');
      } else {
        // Something happened in setting up the request that triggered an Error
        console.log('requete erreur : ' + error);
        res.status(500).send('The server encountered an unexpected condition which prevented it from fulfilling the request.')
      }
    });
});

module.exports = router;