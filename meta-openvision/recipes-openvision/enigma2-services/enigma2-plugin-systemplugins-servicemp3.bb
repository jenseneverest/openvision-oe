DESCRIPTION = "servicemp3 for enigma2"
AUTHOR = "OpenPLi team <info@openpli.org>"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES += "virtual/enigma2-mediaservice"
RPROVIDES_${PN} += "virtual/enigma2-mediaservice"

GST_BASE_RDEPS = "\
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-base-alsa \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-base-app \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-base-audioconvert \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-base-audioresample \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-base-audiorate \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-base-videoconvert \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-base-ivorbisdec \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-base-ogg \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-base-opus \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-base-playback \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-base-subparse \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-base-typefindfunctions \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-base-vorbis \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-base-rawparse \
	"

GST_GOOD_RDEPS = "\
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-good-apetag \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-good-audioparsers \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-good-autodetect \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-good-avi \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-good-flac \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-good-flv \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-good-icydemux \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-good-id3demux \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-good-isomp4 \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-good-matroska \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-good-mpg123 \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-good-rtp \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-good-rtpmanager \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-good-rtsp \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-good-soup \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-good-udp \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-good-wavparse \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-good-wavpack \
	"

GST_BAD_RDEPS = "\
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-bad-autoconvert \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-bad-dashdemux \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-bad-mms \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-bad-mpegpsdemux \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-bad-mpegtsdemux \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-bad-rtmp \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-bad-smoothstreaming \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-bad-faad \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-bad-hls \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-bad-opusparse \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-bad-videoparsersbad \
	"

GST_UGLY_RDEPS = "\
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-ugly-amrnb \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-ugly-amrwbdec \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-ugly-asf \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-ugly-cdio \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugins-ugly-dvdsub \
	"

DEPENDS = "\
	enigma2 \
	gst-plugins-base gstreamer \
	${PYTHONNAMEONLY} \
	"

RDEPENDS_${PN} = "\
	enigma2 \
	"

RDEPENDS_${PN} = "\
	glib-networking \
	${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer${GST_VERSION}", "gst", d)}-plugin-subsink \
	virtual/gst-dvbmediasink \
	${GST_BASE_RDEPS} \
	${GST_GOOD_RDEPS} \
	${GST_BAD_RDEPS} \
	${GST_UGLY_RDEPS} \
	"

SRC_URI = "${@bb.utils.contains("MACHINE_FEATURES", "nogamma", "git://github.com/OpenVisionE2/servicemp3amlogic.git", "git://github.com/OpenVisionE2/servicemp3.git", d)}"

S = "${WORKDIR}/git"

inherit autotools gitpkgv ${PYTHONNAMEONLY}native pkgconfig rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

EXTRA_OECONF = "\
	--with-gstversion=${GST_VERSION} \
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	${@bb.utils.contains("MACHINE_FEATURES", "nogamma", "--with-boxtype=${MACHINE} --with-boxbrand=${BOX_BRAND} --with-amlogic" , "", d)} \
	"

FILES_${PN} = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceMP3/*.${PYTHONEXTENSION} \
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceMP3/servicemp3.so"

FILES_${PN}-dev = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceMP3/servicemp3.la"

CXXFLAGS_append_cube = " -std=c++11 -fPIC -fno-strict-aliasing"
CXXFLAGS_append_su980 = " -std=c++11 -fPIC -fno-strict-aliasing"
