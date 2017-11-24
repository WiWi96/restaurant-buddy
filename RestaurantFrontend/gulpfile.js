var gulp = require('gulp');
var less = require('gulp-less');
var browserSync = require('browser-sync').create();
var uglify = require('gulp-uglify');
var cssnano = require('gulp-cssnano');
var useref = require('gulp-useref');
var gulpIf = require('gulp-if');
var runSequence = require('run-sequence');

gulp.task('start', function (callback) {
    runSequence(['less', 'useref', 'browserSync', 'watch'],
    callback
  )
});

gulp.task('watch', ['browserSync', 'less'], function () {
    gulp.watch('app/less/**/*.less', ['less']);
    gulp.watch('app/css/**/*.css', browserSync.reload);
    gulp.watch('app/*.html', browserSync.reload);
    gulp.watch('app/js/**/*.js', browserSync.reload);
})

gulp.task('less', function () {
    return gulp.src('app/less/**/*.less')
        .pipe(less())
        .pipe(gulp.dest('app/css'))
});

gulp.task('browserSync', function () {
    browserSync.init({
        server: {
            baseDir: 'app'
        },
    })
})

gulp.task('useref', function(){
    return gulp.src('app/*.html')
      .pipe(useref())
      .pipe(gulpIf('js/**/*.js', uglify()))
      .pipe(gulpIf('*.css', cssnano()))
      .pipe(gulp.dest('dist'))
  });