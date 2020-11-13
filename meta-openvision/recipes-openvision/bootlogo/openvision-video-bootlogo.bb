DESCRIPTION = "Open Vision video bootlogo"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CC-BY-NC-ND-4.0"
LIC_FILES_CHKSUM = "file://${OPENVISION_BASE}/meta-openvision/licenses/CC-BY-NC-ND-4.0;md5=8009795292660aa9c8da059e5b1581c1"

RDEPENDS_${PN} += "exteplayer3"

S = "${WORKDIR}"

SRC_URI = "file://bootlogo.mp4"

do_install() {
	install -d ${D}${datadir}
	install ${S}/bootlogo.mp4 ${D}${datadir}/
}

FILES_${PN} = "${datadir}"
