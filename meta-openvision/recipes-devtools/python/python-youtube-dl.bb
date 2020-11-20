SUMMARY = "Download videos from YouTube (and more sites)"
DESCRIPTION = "youtube-dl is a small command-line program to download videos \
from YouTube.com and a few more sites. It requires the Python interpreter \
(2.6, 2.7, or 3.2+), and it is not platform specific"
HOMEPAGE = "https://youtube-dl.org"
SECTION = "devel/python"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=7246f848faa4e9c9fc0ea91122d6e680"

DEPENDS = "libxml2 bash-completion"

PV = "2020.11.19"

SRC_URI = "https://github.com/ytdl-org/youtube-dl/releases/download/2020.11.19/youtube-dl-${PV}.tar.gz"

SRC_URI[md5sum] = "811b2a1a85ca4cefb94bdd066d027c87"
SRC_URI[sha256sum] = "f8c14d9eb2fd8fe7242de8b96f2c918810867c518a162405644f483dcd14be9e"

S = "${WORKDIR}/youtube-dl"

inherit ${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "setuptools3", "setuptools", d)}

EXTRA_OEMAKE = "PYTHON=${PYTHON}"

do_compile_prepend() {
	oe_runmake lazy-extractors youtube-dl.bash-completion
}

do_install_append() {
	mv ${D}${datadir}${sysconfdir} ${D}${sysconfdir}
	install -m 0755 -d ${D}${sysconfdir}/bash_completion.d
	install -m 0644 youtube-dl.bash-completion ${D}${sysconfdir}/bash_completion.d
}

RDEPENDS_${PN} = " \
	${PYTHONNAMEONLY}-email \
	${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "", " \
	python-gdata \
	python-subprocess", d)} \
	${PYTHONNAMEONLY}-unixadmin \
	${PYTHONNAMEONLY}-ctypes \
	${PYTHONNAMEONLY}-argparse \
	${PYTHONNAMEONLY}-html \
	"

RDEPENDS_{PN}-src = "${PN}"

FILES_${PN}-src = " \
	${libdir}/${PYTHON_DIR}/site-packages/*/*.py \
	${libdir}/${PYTHON_DIR}/site-packages/*/*/*.py \
	${libdir}/${PYTHON_DIR}/site-packages/*/*/*/*.py \
	${libdir}/${PYTHON_DIR}/site-packages/*/*/*/*/*.py \
	${datadir}${sysconfdir}/* \
	"

FILES_${PN} += "${sysconfdir}"
