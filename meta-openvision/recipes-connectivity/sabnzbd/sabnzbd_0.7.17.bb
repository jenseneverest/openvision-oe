MAINTAINER = "team@sabnzbd.org"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYRIGHT.txt;md5=183ca88c5404ea8f9e484ad8d271aab3"

DEPENDS = "${PYTHONNAMEONLY}"
RDEPENDS_${PN} = "\
	${PYTHONNAMEONLY}-core ${PYTHONNAMEONLY}-shell ${PYTHONNAMEONLY}-compression ${PYTHONNAMEONLY}-crypt ${PYTHONNAMEONLY}-ctypes \
	${PYTHONNAMEONLY}-cheetah ${PYTHONNAMEONLY}-misc ${@bb.utils.contains("PYTHONNAMEONLY", "python3", "", "python-subprocess", d)} ${PYTHONNAMEONLY}-html ${PYTHONNAMEONLY}-email ${PYTHONNAMEONLY}-yenc \
	"
RRECOMMENDS_${PN} = "par2cmdline unrar"

SRC_URI = "${SOURCEFORGE_MIRROR}/sabnzbdplus/sabnzbdplus/${PV}/SABnzbd-${PV}-src.tar.gz \
	file://sabnzbd \
	file://sabnzbd.ini"

SRC_URI[md5sum] = "5056006fb15d6e62654af9f80955eba3"
SRC_URI[sha256sum] = "a501517dbaf161deab2153118ff3b44512ee1d8984c3603bf17c593cf080eb09"

S = "${WORKDIR}/SABnzbd-${PV}"

INSTALLDIR = "${libdir}/${PN}"

PACKAGES = "${PN}-doc ${PN}-src ${PN}"

FILES_${PN}-src = "${INSTALLDIR}/*/*.py ${INSTALLDIR}/*/*/*.py"
FILES_${PN}-doc = "${INSTALLDIR}/*.txt ${INSTALLDIR}/licenses ${INSTALLDIR}/interfaces/*/licenses"
FILES_${PN} = "${INSTALLDIR} ${sysconfdir}/init.d/sabnzbd ${sysconfdir}/sabnzbd.ini"

inherit update-rc.d pythonnative compile_python_pyo
INITSCRIPT_NAME = "sabnzbd"
INITSCRIPT_PARAMS = "defaults"

do_install() {
	install -d ${D}${INSTALLDIR}
	cp -r . ${D}${INSTALLDIR}/
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/sabnzbd ${D}${sysconfdir}/init.d/sabnzbd
	install -m 644 ${WORKDIR}/sabnzbd.ini ${D}${sysconfdir}/sabnzbd.ini
}
