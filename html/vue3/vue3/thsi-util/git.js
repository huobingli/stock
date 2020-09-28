/*
 * @Author: COCO
 * @Author2: Booleen to 2019-07-16 21:40:00
 * @Date: 2018-11-08 12:18:13
 * @Last Modified by: mikey.zhaopeng
 * @Last Modified time: 2019-12-04 10:30:12
 * 自动git提交
 */
const shelljs = require('shelljs');
const colors = require('colors');
const application = shelljs.exec('cd ..');
const readline = require('readline');
// 获取输入的所有命令
const params = JSON.parse(process.env.npm_config_argv).original;
// -m的参数值
var annotation = '';
// 当没有自定义的注释内容时，提示用户输入
if (params.indexOf('-m') > -1 && params.indexOf('-m') < params.length - 1) {
  annotation = params[params.indexOf('-m') + 1];
  if (annotation.trim() == '') {
    noParams();
  } else {
    gitPush(annotation);
  }
} else {
  noParams();
}

function gitPush(annotation) {
  application.exec('git add .');
  const commitResult = application.exec(`git commit -m "${annotation.trim()}"`);
  if (commitResult.code !== 0) {
    console.log('~ 当前没有可提交的文件 ~'.red);
  }
  application.exec('git pull');
  application.exec('git status');
  // console.log(application.exec('git status'));
  if (application.exec('git status').code === 0) {
    const pushResult = application.exec('git push');
    if (pushResult.code === 0) {
      console.log('代码提交成功！'.green);
      process.exit();
    }
  }
}
// 提示用户输入并且输出用户的输入
function readSyncByRl(tips) {
  tips = tips || '> ';
  return new Promise((resolve) => {
    const rl = readline.createInterface({
      input: process.stdin,
      output: process.stdout
    });

    rl.question(tips, (answer) => {
      rl.close();
      resolve(answer.trim());
    });
  });
}
// 提示结果
function noParams() {
  readSyncByRl('> 请输入提交到gitlab的注释内容：'.green).then((res) => {
    if (res == '') {
      console.log('> 提交gitlab失败！注释内容不可省！'.red)
      process.exit();
    } else {
      gitPush(res);
    }
  });
}