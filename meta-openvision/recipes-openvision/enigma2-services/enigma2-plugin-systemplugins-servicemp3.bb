DESCRIPTION = "servicemp3 for enigma2"
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

DEPENDS = "\
	enigma2 \
	${GSTVNAME}-plugins-base ${@bb.utils.contains("GST_VERSION", "1.0", "gstreamer1.0", "gstreamer", d)} \
	${PYTHONNAMEONLY} \
	"

RDEPENDS_${PN} = "\
	enigma2 \
	"

RDEPENDS_${PN} = "\
	glib-networking \
	${GSTVNAME}-plugin-subsink \
	virtual/${GSTVNAME}-dvbmediasink \
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
	--with-boxtype=${MACHINE} \
	--with-boxbrand=${BOX_BRAND} \
	--with-stbplatform=${STB_PLATFORM} \
	${@bb.utils.contains("MACHINE_FEATURES", "nogamma", "--with-amlogic" , "", d)} \
	"

FILES_${PN} = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceMP3/*.${PYTHONEXTENSION} \
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceMP3/servicemp3.so"

FILES_${PN}-dev = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceMP3/servicemp3.la"

CXXFLAGS_append_cube = " -std=c++11 -fPIC -fno-strict-aliasing"
CXXFLAGS_append_su980 = " -std=c++11 -fPIC -fno-strict-aliasing"
