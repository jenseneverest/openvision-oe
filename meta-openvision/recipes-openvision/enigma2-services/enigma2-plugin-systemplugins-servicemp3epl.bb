DESCRIPTION = "servicemp3 and libeplayer backend for enigma2"
AUTHOR = "OpenPLi team <info@openpli.org>"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES += "virtual/enigma2-mediaservice"
RPROVIDES_${PN} += "virtual/enigma2-mediaservice"

GST_BASE_RDEPS = "\
	${GSTVNAME}-plugins-base-alsa \
	${GSTVNAME}-plugins-base-app \
	${GSTVNAME}-plugins-base-audioconvert \
	${GSTVNAME}-plugins-base-audioresample \
	${GSTVNAME}-plugins-base-audiorate \
	${GSTVNAME}-plugins-base-videoconvert \
	${GSTVNAME}-plugins-base-ivorbisdec \
	${GSTVNAME}-plugins-base-ogg \
	${GSTVNAME}-plugins-base-opus \
	${GSTVNAME}-plugins-base-playback \
	${GSTVNAME}-plugins-base-subparse \
	${GSTVNAME}-plugins-base-typefindfunctions \
	${GSTVNAME}-plugins-base-vorbis \
	${GSTVNAME}-plugins-base-rawparse \
	"

GST_GOOD_RDEPS = "\
	${GSTVNAME}-plugins-good-apetag \
	${GSTVNAME}-plugins-good-audioparsers \
	${GSTVNAME}-plugins-good-autodetect \
	${GSTVNAME}-plugins-good-avi \
	${GSTVNAME}-plugins-good-flac \
	${GSTVNAME}-plugins-good-flv \
	${GSTVNAME}-plugins-good-icydemux \
	${GSTVNAME}-plugins-good-id3demux \
	${GSTVNAME}-plugins-good-isomp4 \
	${GSTVNAME}-plugins-good-matroska \
	${GSTVNAME}-plugins-good-mpg123 \
	${GSTVNAME}-plugins-good-rtp \
	${GSTVNAME}-plugins-good-rtpmanager \
	${GSTVNAME}-plugins-good-rtsp \
	${GSTVNAME}-plugins-good-soup \
	${GSTVNAME}-plugins-good-udp \
	${GSTVNAME}-plugins-good-wavparse \
	${GSTVNAME}-plugins-good-wavpack \
	"

GST_BAD_RDEPS = "\
	${GSTVNAME}-plugins-bad-autoconvert \
	${GSTVNAME}-plugins-bad-dashdemux \
	${GSTVNAME}-plugins-bad-mms \
	${GSTVNAME}-plugins-bad-mpegpsdemux \
	${GSTVNAME}-plugins-bad-mpegtsdemux \
	${GSTVNAME}-plugins-bad-rtmp \
	${GSTVNAME}-plugins-bad-smoothstreaming \
	${GSTVNAME}-plugins-bad-faad \
	${GSTVNAME}-plugins-bad-hls \
	${GSTVNAME}-plugins-bad-opusparse \
	${GSTVNAME}-plugins-bad-videoparsersbad \
	"

GST_UGLY_RDEPS = "\
	${GSTVNAME}-plugins-ugly-amrnb \
	${GSTVNAME}-plugins-ugly-amrwbdec \
	${GSTVNAME}-plugins-ugly-asf \
	${GSTVNAME}-plugins-ugly-cdio \
	${GSTVNAME}-plugins-ugly-dvdsub \
	"

PACKAGECONFIG ??= "gstreamer"
PACKAGECONFIG[gstreamer]       = "--enable-gstreamer --with-gstversion=${GST_VERSION},--disable-gstreamer,${GSTVNAME}-plugins-base gstreamer"
PACKAGECONFIG[libeplayer]      = "--enable-libeplayer3,--disable-libeplayer3,libeplayer3"

DEPENDS = "\
	enigma2 \
	${PYTHONNAMEONLY} \
	"

RDEPENDS_${PN} = "\
	enigma2 \
	${@bb.utils.contains("PACKAGECONFIG", "libeplayer", "libeplayer3", "", d)} \
	"

RRECOMMENDS_${PN} = "\
	${@bb.utils.contains("PACKAGECONFIG", "gstreamer", "\
	glib-networking \
	${GSTVNAME}-plugin-subsink \
	virtual/${GSTVNAME}-dvbmediasink \
	${GST_BASE_RDEPS} \
	${GST_GOOD_RDEPS} \
	${GST_BAD_RDEPS} \
	${GST_UGLY_RDEPS} \
	", "", d)} \
	${@bb.utils.contains("PACKAGECONFIG", "libeplayer", "libeplayer3", "", d)} \
	"

SRC_URI = "git://github.com/OpenVisionE2/servicemp3epl.git;branch=master"

S = "${WORKDIR}/git"

inherit autotools gitpkgv ${PYTHONNAMEONLY}native pkgconfig rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

EXTRA_OECONF = "\
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	"

FILES_${PN} = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceMP3/*.${PYTHONEXTENSION} \
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceMP3/servicemp3.so"

FILES_${PN}-dev = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceMP3/servicemp3.la"
