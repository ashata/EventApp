module.exports = {
  dynamicUrlToDependencies: {
    'home': [
      '/home',
      '/slideshow'
    ]
  },
  staticFileGlobs: [
    'webapp/styles/**.css',
    'webapp/**.html',
    '/webapps/images/**.*',
    '/webapps/js/**.js'
  ],
  stripPrefix: '/webapps/',
  verbose: true,
  runtimeCaching: [{
    urlPattern: /this\\.is\\.a\\.regex/,
    handler: 'networkFirst'
  }]
};