SRC_URI = "${@bb.utils.contains("MACHINE_FEATURES", "nogamma", "git://github.com/OpenVisionE2/servicemp3amlogic.git", "git://github.com/openpli/servicemp3.git;branch=master", d)}"

EXTRA_OECONF_append += "\
	${@bb.utils.contains("MACHINE_FEATURES", "nogamma", "--with-boxtype=${MACHINE} --with-boxbrand=${BOX_BRAND} --with-amlogic" , "", d)} \
	"

CXXFLAGS_append_cube += " -std=c++11 -fPIC -fno-strict-aliasing "
CXXFLAGS_append_su980 += " -std=c++11 -fPIC -fno-strict-aliasing "
