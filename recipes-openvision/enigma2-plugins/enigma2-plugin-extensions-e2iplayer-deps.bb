SUMMARY = "Meta package for installing all dependencies for SSS' E2i Player"
inherit allarch

require conf/license/license-gplv2.inc

RRECOMMENDS_${PN} = " \
	ffmpeg \
	exteplayer3 \
	gstplayer \
	wget \
	hlsdl \
	lsdir \
	f4mdump \
	gst-ifdsrc \
	iptvsubparser \
	rtmpdump \
	duktape \
	uchardet \
	cmdwrapper \
	"

PV = "1.0"

ALLOW_EMPTY_${PN} = "1"
