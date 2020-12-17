SUMMARY = "Download videos from YouTube (and more sites)"
DESCRIPTION = "youtube-dl is a small command-line program to download videos \
from YouTube.com and a few more sites. It requires the Python interpreter \
(2.6, 2.7, or 3.2+), and it is not platform specific"
HOMEPAGE = "https://youtube-dl.org"
SECTION = "devel/python"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=7246f848faa4e9c9fc0ea91122d6e680"

DEPENDS = "libxml2 bash-completion"

PV = "2020.12.14"

SRC_URI = "https://github.com/ytdl-org/youtube-dl/releases/download/${PV}/youtube-dl-${PV}.tar.gz"

SRC_URI[md5sum] = "37ad92ca740ee918b57e6567d3e64670"
SRC_URI[sha256sum] = "9681a5a515cb44ef23c28bd77f6d79d531fdbc7325bdf4bbb7966260b7b64273"

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

include python-package-split.inc

FILES_${PN} += "${sysconfdir}"
