const zipdir = require('zip-dir');

zipdir('./', { saveTo: './release.zip', filter: (path, stat) => !/node_modules\\|node_modules$|\.zip$|\.7z$|\.git\\|\.git$/.test(path) }, function(
  err,
  buffer
) {
  if (!err) {
    console.log('自动压缩成功：文件名称为【release.zip】');
  } else {
    console.log(err);
  }
});
