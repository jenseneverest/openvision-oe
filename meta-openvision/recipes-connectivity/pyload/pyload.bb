DESCRIPTION = "pyLoad is a fast, lightweight and full featured download manager for many One-Click-Hoster"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d4333f07cbfa8fe036e90820f556b2ad"
HOMEPAGE = "http://pyload.org/"
RDEPENDS_${PN} = "\
	${PYTHONNAMEONLY}-compression \
	${PYTHONNAMEONLY}-db \
	${PYTHONNAMEONLY}-email \
	${PYTHONNAMEONLY}-html \
	${PYTHONNAMEONLY}-imaging \
	${PYTHONNAMEONLY}-numbers \
	${PYTHONNAMEONLY}-pprint \
	${PYTHONNAMEONLY}-pycrypto \
	${PYTHONNAMEONLY}-pycurl \
	${PYTHONNAMEONLY}-subprocess \
	${PYTHONNAMEONLY}-terminal \
	${PYTHONNAMEONLY}-unixadmin \
	${PYTHONNAMEONLY}-xmlrpc \
	"
RRECOMMENDS_${PN} = "unrar"

PV = "0.4.9"

inherit update-rc.d compile_python_pyo

SRC_URI = "http://sources.openelec.tv/mirror/pyload/pyload-src-v${PV}.zip \
	file://pyload.init \
	file://pyload.tar.gz.defaults"
SRC_URI[md5sum] = "28876150af22999b6f539c8579d3b415"
SRC_URI[sha256sum] = "f937631d376216bc830d6ffcd5b4ecb1806afd4012a184849da1a333a7ba0016"

S = "${WORKDIR}/pyload"

FILES_${PN} = "${prefix}/pyload/* ${sysconfdir}/*"

INITSCRIPT_NAME = "${PN}"
INITSCRIPT_PARAMS = "defaults 60 "

do_install() {
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${prefix}/pyload

	cp -r ${S}/icons ${D}${prefix}/pyload
	cp -r ${S}/locale ${D}${prefix}/pyload
	cp -r ${S}/module ${D}${prefix}/pyload
	cp -r ${S}/scripts ${D}${prefix}/pyload
	install -m 755 ${S}/pyLoadCli.py ${D}${prefix}/pyload
	install -m 755 ${S}/pyLoadCore.py ${D}${prefix}/pyload
	install -m 755 ${S}/systemCheck.py ${D}${prefix}/pyload
	cp ${WORKDIR}/pyload.tar.gz.defaults ${D}${prefix}/pyload/pyload-defaults.tar.gz
	
	install -m 0755 ${WORKDIR}/pyload.init ${D}${sysconfdir}/init.d/pyload
}

