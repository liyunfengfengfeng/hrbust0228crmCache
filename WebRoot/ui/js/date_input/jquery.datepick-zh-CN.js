/* Chinese initialisation for the jQuery UI date picker plugin. */
/* Written by Cloudream (cloudream@gmail.com). */
(function($) {
	$.datepick.regional['zh-CN'] = {
		clearText: 'clear', clearStatus: 'clear',
		closeText: 'close', closeStatus: 'close',
		prevText: '&#x3c;preMon', prevStatus: 'lastMonth',
		prevBigText: '&#x3c;&#x3c;', prevBigStatus: 'lastYear',
		nextText: 'nexMon&#x3e;', nextStatus: 'nextMonth',
		nextBigText: '&#x3e;&#x3e;', nextBigStatus: 'nextYear',
		currentText: 'today', currentStatus: 'curMon',
		monthNames: ['01','02','03','04','05','06',
		     		'07','08','09','10','11','12'],
		monthNamesShort: ['01','02','03','04','05','06',
		'07','08','09','10','11','12'],
		monthStatus: 'month', yearStatus: 'year',
		weekHeader: 'week', weekStatus: 'week',
		dayNames: ['Sun','Mon','Tus','Wed','Thu','Fri','Sat'],
		dayNamesShort: ['Sun','Mon','Tus','Wed','Thu','Fri','Sat'],
		dayNamesMin: ['7','1','2','3','4','5','6'],
		dayStatus: '设置 DD 为一周起始', dateStatus: '选择 m月 d日, DD',
		dateFormat: 'yy-mm-dd', firstDay: 1,
		initStatus: 'select', isRTL: false};
	$.datepick.setDefaults($.datepick.regional['zh-CN']);
})(jQuery);
