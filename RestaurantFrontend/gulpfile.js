var gulp = require('gulp');
var less = require('gulp-less');
var browserSync = require('browser-sync').create();

gulp.task('default', function () { 
    console.log('Hello world!') 
});

gulp.task('watch', function(){
    gulp.watch('app/less/**/*.less', ['less']); 
    gulp.watch('app/*.html', ['html']);
    gulp.watch('app/js/**/*.js', ['js']);
  })

gulp.task('less', function(){
    return gulp.src('app/less/**/*.less')
      .pipe(less()) // Using gulp-sass
      .pipe(gulp.dest('app/css'))
  });